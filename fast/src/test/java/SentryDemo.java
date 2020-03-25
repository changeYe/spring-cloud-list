import io.sentry.Sentry;
import io.sentry.SentryClient;
import io.sentry.context.Context;
import io.sentry.event.BreadcrumbBuilder;
import io.sentry.event.UserBuilder;

/**
 * @author yuantongqin
 * description:
 * 2020/3/25
 */
public class SentryDemo {

    private static SentryClient sentry;

    public static void main(String[] args) {
        String dsn = "https://0e977d9bf7534ebb83653f8ade1eea00@sentry.io/5174019";
        sentry = Sentry.init(dsn);

//        sentry = SentryClientFactory.sentryClient();

        SentryDemo myClass = new SentryDemo();
        try {
            myClass.unsafeMethod();
        }catch (Exception e){
            Context sentryContext = sentry.getContext();
            sentryContext.addTag("subject", "fast");

            sentry.sendException(e);
        }
//        myClass.logWithStaticAPI();

    }

    void unsafeMethod() {
        throw new UnsupportedOperationException("You shouldn't call this!");
    }

    /**
     * Examples using the (recommended) static API.
     */
    void logWithStaticAPI() {
        // Note that all fields set on the context are optional. Context data is copied onto
        // all future events in the current context (until the context is cleared).

        // Record a breadcrumb in the current context. By default the last 100 breadcrumbs are kept.
        Sentry.getContext().recordBreadcrumb(
                new BreadcrumbBuilder().setMessage("User made an action").build()
        );

        // Set the user in the current context.
        Sentry.getContext().setUser(
                new UserBuilder().setEmail("change@sentry.io").build()
        );

        // Add extra data to future events in this context.
        Sentry.getContext().addExtra("extra", "thing");

        // Add an additional tag to future events in this context.
        Sentry.getContext().addTag("tagName", "tagValue");

        /*
        This sends a simple event to Sentry using the statically stored instance
        that was created in the ``main`` method.
        */
        Sentry.capture("This is a test");


        try {
            unsafeMethod();
        } catch (Exception e) {
            // This sends an exception event to Sentry using the statically stored instance
            // that was created in the ``main`` method.
            Sentry.capture(e);
        }
    }

}

//package com.algorithm;
//
//import java.util.Iterator;
//
//import org.springframework.lang.Nullable;
//
///**
// * @author yuantongqin
// * description:
// * 2020/4/30
// */
//public class Splitter {
//
//    public static void checkArgument(boolean expression, @Nullable Object errorMessage) {
//        if (!expression) {
//            throw new IllegalArgumentException(String.valueOf(errorMessage));
//        }
//    }
//
//
//    private interface Strategy {
//        Iterator<String> iterator(Splitter splitter, CharSequence toSplit);
//    }
//
//    public static Splitter on(final String separator) {
//        checkArgument(separator.length() != 0, "The separator may not be the empty string.");
//        if (separator.length() == 1) {
//            return Splitter.on(separator.charAt(0));
//        }
//        return new Splitter(
//                new Strategy() {
//                    @Override
//                    public SplittingIterator iterator(Splitter splitter, CharSequence toSplit) {
//                        return new SplittingIterator(splitter, toSplit) {
//                            @Override
//                            public int separatorStart(int start) {
//                                int separatorLength = separator.length();
//
//                                positions:
//                                for (int p = start, last = toSplit.length() - separatorLength; p <= last; p++) {
//                                    for (int i = 0; i < separatorLength; i++) {
//                                        if (toSplit.charAt(i + p) != separator.charAt(i)) {
//                                            continue positions;
//                                        }
//                                    }
//                                    return p;
//                                }
//                                return -1;
//                            }
//
//                            @Override
//                            public int separatorEnd(int separatorPosition) {
//                                return separatorPosition + separator.length();
//                            }
//                        };
//                    }
//                });
//    }
//
//
//    private abstract static class SplittingIterator extends AbstractIterator<String> {
//        final CharSequence toSplit;
//        final CharMatcher trimmer;
//        final boolean omitEmptyStrings;
//
//        /**
//         * Returns the first index in {@code toSplit} at or after {@code start} that contains the
//         * separator.
//         */
//        abstract int separatorStart(int start);
//
//        /**
//         * Returns the first index in {@code toSplit} after {@code separatorPosition} that does not
//         * contain a separator. This method is only invoked after a call to {@code separatorStart}.
//         */
//        abstract int separatorEnd(int separatorPosition);
//
//        int offset = 0;
//        int limit;
//
//        protected SplittingIterator(Splitter splitter, CharSequence toSplit) {
//            this.trimmer = splitter.trimmer;
//            this.omitEmptyStrings = splitter.omitEmptyStrings;
//            this.limit = splitter.limit;
//            this.toSplit = toSplit;
//        }
//
//        @Override
//        protected String computeNext() {
//            /*
//             * The returned string will be from the end of the last match to the beginning of the next
//             * one. nextStart is the start position of the returned substring, while offset is the place
//             * to start looking for a separator.
//             */
//            int nextStart = offset;
//            while (offset != -1) {
//                int start = nextStart;
//                int end;
//
//                int separatorPosition = separatorStart(offset);
//                if (separatorPosition == -1) {
//                    end = toSplit.length();
//                    offset = -1;
//                } else {
//                    end = separatorPosition;
//                    offset = separatorEnd(separatorPosition);
//                }
//                if (offset == nextStart) {
//                    /*
//                     * This occurs when some pattern has an empty match, even if it doesn't match the empty
//                     * string -- for example, if it requires lookahead or the like. The offset must be
//                     * increased to look for separators beyond this point, without changing the start position
//                     * of the next returned substring -- so nextStart stays the same.
//                     */
//                    offset++;
//                    if (offset > toSplit.length()) {
//                        offset = -1;
//                    }
//                    continue;
//                }
//
//                while (start < end && trimmer.matches(toSplit.charAt(start))) {
//                    start++;
//                }
//                while (end > start && trimmer.matches(toSplit.charAt(end - 1))) {
//                    end--;
//                }
//
//                if (omitEmptyStrings && start == end) {
//                    // Don't include the (unused) separator in next split string.
//                    nextStart = offset;
//                    continue;
//                }
//
//                if (limit == 1) {
//                    // The limit has been reached, return the rest of the string as the
//                    // final item. This is tested after empty string removal so that
//                    // empty strings do not count towards the limit.
//                    end = toSplit.length();
//                    offset = -1;
//                    // Since we may have changed the end, we need to trim it again.
//                    while (end > start && trimmer.matches(toSplit.charAt(end - 1))) {
//                        end--;
//                    }
//                } else {
//                    limit--;
//                }
//
//                return toSplit.subSequence(start, end).toString();
//            }
//            return endOfData();
//        }
//    }
//}

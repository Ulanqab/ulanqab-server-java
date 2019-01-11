package com.ulanqab.daily;

public class Constants {

    public static final String APP_NAME = "PetLover";

    public static final Long TOKEN_LIFE = 3153600000L;

    public static class STATUS_CODE {
        public static final int SUCCESS = 0;
        public static final int ERROR_COMMON = -1;
        public static final int ERROR_TOKEN_INVALID = -1000;
        public static final int ERROR_RE_LOGIN = -1001;
        public static final int ERROR_PERFECT_PROFILE = -1010;
        public static final int ERROR_BIND_USER_NAME = -1020;
        public static final int ERROR_APP_ID_INVALID = -9990;
        public static final int ERROR_DATA_DECODE = -9999;
        public static final int ERROR_NOT_EXISTED = -404;

        public static final int ERROR_UNKNOWN = -999;
    }

    public static class HTTP_HEADER {
        public static final String TOKEN = "TOKEN";

        static final String APP_ID = "APP-ID";
        static final String APP_VERSION = "APP-VERSION";
        static final String NETWORK = "NETWORK";
        static final String SCREEN_SCALE = "SCREEN-SCALE";
        static final String SCREEN_WIDTH = "SCREEN-WIDTH";
        static final String SCREEN_HEIGHT = "SCREEN-HEIGHT";
        static final String LANGUAGE = "Accept-Language";
    }

    public static class PageInfo {
        public static final Integer PAGE_SIZE = 5;
    }
}

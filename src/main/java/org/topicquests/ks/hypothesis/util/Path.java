package org.topicquests.ks.hypothesis.util;

public class Path {

    public static class Web {
        public static final String INDEX = "/index";
        public static final String LOGIN = "/login";
        public static final String LOGOUT = "/logout";
        // a json REST for hypothesis harvester
        public static final String HYP = "/hyp/all/:offset/:count";
        // full text search
        public static final String HYP_TEXT = "/hyp/text/:text/:offset/:count";
        // individual views -- not sure these are needed
        public static final String HYP_ONE_R = "/hyp/oner/:res/:offset/:count";
        public static final String HYP_ONE_U = "/hyp/oneU/:usr/:offset/:count";
        public static final String HYP_ONE_T = "/hyp/onet/:tag/:offset/:count";
        // pivot objects
        public static final String HYP_RESOURCES = "/hyp/resources/:offset/:count";
        public static final String HYP_USERS = "/hyp/users/:offset/:count";
        public static final String HYP_TAGS = "/hyp/tags/:offset/:count";
        public static final String HYP_GROUPS = "/hyp/groups/:offset/:count";
        // pivot views
        public static final String HYP_TAG_PIV = "/hyp/tagpiv/:tag/:offset/:count";
        public static final String HYP_USR_PIV = "/hyp/usrpiv/:user/:offset/:count";
        public static final String HYP_RES_PIV = "/hyp/respiv/:resource/:offset/:count";
        public static final String HYP_GRP_PIV = "/hyp/grppiv/:group/:offset/:count";
        // pivot page queries
        public static final String HYP_RES_BY_USR = "/hyp/resusr/:user/:offset/:count";
        public static final String HYP_RES_BY_TAG = "/hyp/restag/:tag/:offset/:count";
        public static final String HYP_RES_BY_GRP = "/hyp/resgrp/:group/:offset/:count";
        public static final String HYP_TAG_BY_USR = "/hyp/tagusr/:user/:offset/:count";
        public static final String HYP_TAG_BY_RES = "/hyp/tagres/:resource/:offset/:count";
        public static final String HYP_TAG_BY_GRP = "/hyp/taggrp/:group/:offset/:count";
        public static final String HYP_GRP_BY_USR = "/hyp/grpusr/:user/:offset/:count";
        public static final String HYP_GRP_BY_TAG = "/hyp/grptag/:tag/:offset/:count";
        public static final String HYP_GRP_BY_RES = "/hyp/grpres/:resource/:offset/:count";
        public static final String HYP_USR_BY_RES = "/hyp/usrres/:resource/:offset/:count";
        public static final String HYP_USR_BY_TAG = "/hyp/usrtag/:tag/:offset/:count";
        public static final String HYP_USR_BY_GRP = "/hyp/usrgrp/:group/:offset/:count";


        public static final String HYP_PIV_2 = "/hyp/piv2/:featureA/featureB/:offset/:count";

    }

    public static class Template {
        public static final String INDEX = "/velocity/index/index.vm";
        public static final String LOGIN = "/velocity/login/login.vm";
        public static final String NOT_FOUND = "/velocity/notFound.vm";
    }

}

package com.cpa.search.testcase.searchHistory;

import com.cpa.search.base.BootStrap;
import com.cpa.search.base.BootStrap;
import org.testng.annotations.Test;

public class GetSearchHistoryDefinations  extends BootStrap{
        String apiUrl = baseURI + "api/searchhistory/definitions";

        @Test(priority = 1)
        public void getSearchHistoryDefinations_200() {
            log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
            validateStatusCode(apiUrl, "", 200, "GET");
        }

        @Test(priority = 2)
        public void getSearchHistoryDefinations_USPTO_East_ResponseMessage() {
            log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
            validateKeyValueFromResponse(apiUrl,"name[0]","USPTO East","GET","");
        }
        @Test(priority = 3)
        public void getSearchHistoryDefinations_Google_Search_ResponseMessage() {
            log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
            validateKeyValueFromResponse(apiUrl,"name[1]","Google Search","GET","");
        }
        @Test(priority = 4)
        public void getSearchHistoryDefinations_Google_Patents_ResponseMessage() {
            log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
            validateKeyValueFromResponse(apiUrl,"name[2]","Google Patents","GET","");
        }
        @Test(priority = 5)
        public void getSearchHistoryDefinations_Panasonic_PatentSquare_ResponseMessage() {
            log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
            validateKeyValueFromResponse(apiUrl,"name[3]","Panasonic PatentSquare","GET","");
        }
        @Test(priority = 6)
        public void getSearchHistoryDefinations_ProQuest_ResponseMessage() {
            log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
            validateKeyValueFromResponse(apiUrl,"name[4]","ProQuest","GET","");
        }
        @Test(priority = 7)
        public void getSearchHistoryDefinations_IEEE_Xplore_ResponseMessage() {
            log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
            validateKeyValueFromResponse(apiUrl,"name[5]","IEEE Xplore","GET","");
        }
        @Test(priority = 8)
        public void getSearchHistoryDefinations_Taiwan_Patent_Search_ResponseMessage() {
            log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
            validateKeyValueFromResponse(apiUrl,"name[6]","Taiwan Patent Search","GET","");
        }
        @Test(priority = 9)
        public void getSearchHistoryDefinations_AES_ResponseMessage() {
            log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
            validateKeyValueFromResponse(apiUrl,"name[7]","AES","GET","");
        }
        @Test(priority = 10)
        public void getSearchHistoryDefinations_STN_ResponseMessage() {
            log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
            validateKeyValueFromResponse(apiUrl,"name[8]","STN","GET","");
        }
        @Test(priority = 11)
        public void getSearchHistoryDefinations_Orbit_ResponseMessage() {
            log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
            validateKeyValueFromResponse(apiUrl,"name[9]","Orbit","GET","");
        }
        @Test(priority = 12)
        public void getSearchHistoryDefinations_ACM_ResponseMessage() {
            log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
            validateKeyValueFromResponse(apiUrl,"name[10]","ACM","GET","");
        }
        @Test(priority = 13)
        public void getSearchHistoryDefinations_Pubmed_ResponseMessage() {
            log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
            validateKeyValueFromResponse(apiUrl,"name[11]","Pubmed","GET","");
        }
    @Test(priority = 14)
    public void getSearchHistoryDefinations_Engineering_Village_ResponseMessage() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl,"name[12]","Engineering Village","GET","");
    }
    @Test(priority = 15)
    public void getSearchHistoryDefinations_Google_Scholar_ResponseMessage() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl,"name[13]","Google Scholar","GET","");
    }
    @Test(priority = 16)
    public void getSearchHistoryDefinations_Robotics_and_Automation_Society_ResponseMessage() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl,"name[14]","Robotics and Automation Society","GET","");
    }

    @Test(priority = 17)
    public void getSearchHistoryDefinations_Minesoft_PatBase_ResponseMessage() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl,"name[15]","Minesoft PatBase","GET","");
    }
    @Test(priority = 18)
    public void getSearchHistoryDefinations_Other_ResponseMessage() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl,"name[16]","Other","GET","");
    }
    @Test(priority = 19)
    public void getSearchHistoryDefinations_Factiva_ResponseMessage() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl,"name[17]","Factiva","GET","");
    }
    @Test(priority = 20)
    public void getSearchHistoryDefinations_YouTube_ResponseMessage() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl,"name[18]","YouTube","GET","");
    }
    @Test(priority = 21)
    public void getSearchHistoryDefinations_Innography_Advanced_Analysis_ResponseMessage() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl,"name[19]","Innography Advanced Analysis","GET","");
    }
    @Test(priority = 22)
    public void getSearchHistoryDefinations_STN_Columns_ResponseMessage() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl,"columns[8].type[1]","image","GET","");
    }
    @Test(priority = 23)
    public void getSearchHistoryDefinations_Invalid_404() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateStatusCode(baseURI + "api/searchhistory/de", "", 404, "GET");
    }
    @Test(priority = 24)
    public void getSearchHistoryDefinations_Invalid_ResponseMessage() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateResponseMessage(baseURI + "api/searchhistory/de","","The resource you are looking for has been removed, had its name changed, or is temporarily unavailable.","GET");
    }
    @Test(priority = 25)
    public void getSearchHistoryDefinations_ResponseTime() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateResponseTime(this.getClass().getSimpleName(), apiUrl, "", BENCHMARK_RESPONSE_TIME, "GET");
    }

}

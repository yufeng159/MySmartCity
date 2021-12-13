package com.example.smartcity.bean;

import java.util.List;

public class liandong {

    private String provinceCode;
    private String provinceName;
    private List<MallCityListDTO> mallCityList;

    public static class MallCityListDTO {
        private String cityCode;
        private String cityName;
        private List<MallAreaListDTO> mallAreaList;

        public static class MallAreaListDTO {
            private String areaCode;
            private String areaName;
        }
    }
}

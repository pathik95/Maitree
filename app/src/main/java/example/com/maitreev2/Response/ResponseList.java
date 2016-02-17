package example.com.maitreev2.Response;

import java.util.List;

/**
 * Created by Hello on 09-02-2016.
 */
public class ResponseList {

    /**
     * date : 2016-01-13
     * placedetails : [{"placeid":"1","placename":"Place1","placedate":"2016-01-13","placetime":"12:12:12","icon":""},{"placeid":"2","placename":"place2","placedate":"2016-01-13","placetime":"10:10:10","icon":""}]
     * meetingpoints : [{"id":"1","address":"meetpoint1","date":"2016-01-13","time":"12:12:13","lat":"12.1223","lang":"12.134"},{"id":"2","address":"meetpoint2","date":"2016-01-13","time":"09:09:09","lat":"52.12","lang":"53.12"}]
     * pickuppoints : [{"id":"1","address":"pickuppoint1","date":"2016-01-13","time":"12:20:20","lat":"12.2304","lang":"11.0341"}]
     */

    private List<DatesEntity> Dates;
    /**
     * hostid : 1
     * hostname : Chirag Pandya
     * hostpic : null
     */
    public void setDates(List<DatesEntity> Dates) {
        this.Dates = Dates;
    }

    public List<DatesEntity> getDates() {
        return Dates;
    }



    public static class DatesEntity {
        private String date;
        /**
         * placeid : 1
         * placename : Place1
         * placedate : 2016-01-13
         * placetime : 12:12:12
         * icon :
         */

        private List<PlacedetailsEntity> placedetails;
        /**
         * id : 1
         * address : meetpoint1
         * date : 2016-01-13
         * time : 12:12:13
         * lat : 12.1223
         * lang : 12.134
         */

        private List<MeetingpointsEntity> meetingpoints;
        /**
         * id : 1
         * address : pickuppoint1
         * date : 2016-01-13
         * time : 12:20:20
         * lat : 12.2304
         * lang : 11.0341
         */

        private List<PickuppointsEntity> pickuppoints;

        public void setDate(String date) {
            this.date = date;
        }

        public void setPlacedetails(List<PlacedetailsEntity> placedetails) {
            this.placedetails = placedetails;
        }

        public void setMeetingpoints(List<MeetingpointsEntity> meetingpoints) {
            this.meetingpoints = meetingpoints;
        }

        public void setPickuppoints(List<PickuppointsEntity> pickuppoints) {
            this.pickuppoints = pickuppoints;
        }

        public String getDate() {
            return date;
        }

        public List<PlacedetailsEntity> getPlacedetails() {
            return placedetails;
        }

        public List<MeetingpointsEntity> getMeetingpoints() {
            return meetingpoints;
        }

        public List<PickuppointsEntity> getPickuppoints() {
            return pickuppoints;
        }

        public static class PlacedetailsEntity {
            private String placeid;
            private String placename;
            private String placedate;
            private String placetime;
            private String icon;

            public void setPlaceid(String placeid) {
                this.placeid = placeid;
            }

            public void setPlacename(String placename) {
                this.placename = placename;
            }

            public void setPlacedate(String placedate) {
                this.placedate = placedate;
            }

            public void setPlacetime(String placetime) {
                this.placetime = placetime;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public String getPlaceid() {
                return placeid;
            }

            public String getPlacename() {
                return placename;
            }

            public String getPlacedate() {
                return placedate;
            }

            public String getPlacetime() {
                return placetime;
            }

            public String getIcon() {
                return icon;
            }
        }

        public static class MeetingpointsEntity {
            private String id;
            private String address;
            private String date;
            private String time;
            private String lat;
            private String lang;

            public void setId(String id) {
                this.id = id;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public void setTime(String time) {
                this.time = time;
            }

            public void setLat(String lat) {
                this.lat = lat;
            }

            public void setLang(String lang) {
                this.lang = lang;
            }

            public String getId() {
                return id;
            }

            public String getAddress() {
                return address;
            }

            public String getDate() {
                return date;
            }

            public String getTime() {
                return time;
            }

            public String getLat() {
                return lat;
            }

            public String getLang() {
                return lang;
            }
        }

        public static class PickuppointsEntity {
            private String id;
            private String address;
            private String date;
            private String time;
            private String lat;
            private String lang;

            public void setId(String id) {
                this.id = id;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public void setTime(String time) {
                this.time = time;
            }

            public void setLat(String lat) {
                this.lat = lat;
            }

            public void setLang(String lang) {
                this.lang = lang;
            }

            public String getId() {
                return id;
            }

            public String getAddress() {
                return address;
            }

            public String getDate() {
                return date;
            }

            public String getTime() {
                return time;
            }

            public String getLat() {
                return lat;
            }

            public String getLang() {
                return lang;
            }
        }
    }
}

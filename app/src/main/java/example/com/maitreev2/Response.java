package example.com.maitreev2;

import java.util.List;

/**
 * Created by Hello on 28-01-2016.
 */
public class Response {



    private List<DatesEntity> Dates;
    /**
     * hostid : 1
     * hostname : Chirag Pandya
     * address : 41,Dipali Soc.,Near Madhuvrund soc ,Ghatlodia Ahmedabad
     * mobno : 9123435781
     * desc : Mr chirag pandya is a lecturar in ldrp college ,he is master in c, c++ languange
     he is working with maitree foundation since 2002  his father is also a member of maitree foundation
     * lat : 12.002
     * lang : 10.002
     * hostpic : null
     */

    private List<HostEntity> Host;

    public void setDates(List<DatesEntity> Dates) {
        this.Dates = Dates;
    }

    public List<DatesEntity> getDates() {
        return Dates;
    }

    public void setHost(List<HostEntity> Host) {
        this.Host = Host;
    }

    public List<HostEntity> getHost() {
        return Host;
    }

    public static class DatesEntity {
        /**
         * placeid : 1
         * placename : Place1
         * placedate : 2016-01-13
         * placetime : 12:12:12
         * basedesc : description1
         * extradesc : description2
         * icon :
         * img1 :
         * img2 :
         * img3 :
         * lat : 12.123
         * lang : 12.1234
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

        public void setPlacedetails(List<PlacedetailsEntity> placedetails) {
            this.placedetails = placedetails;
        }

        public void setMeetingpoints(List<MeetingpointsEntity> meetingpoints) {
            this.meetingpoints = meetingpoints;
        }

        public void setPickuppoints(List<PickuppointsEntity> pickuppoints) {
            this.pickuppoints = pickuppoints;
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
            private String basedesc;
            private String extradesc;
            private String icon;
            private String img1;
            private String img2;
            private String img3;
            private String lat;
            private String lang;

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

            public void setBasedesc(String basedesc) {
                this.basedesc = basedesc;
            }

            public void setExtradesc(String extradesc) {
                this.extradesc = extradesc;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public void setImg1(String img1) {
                this.img1 = img1;
            }

            public void setImg2(String img2) {
                this.img2 = img2;
            }

            public void setImg3(String img3) {
                this.img3 = img3;
            }

            public void setLat(String lat) {
                this.lat = lat;
            }

            public void setLang(String lang) {
                this.lang = lang;
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

            public String getBasedesc() {
                return basedesc;
            }

            public String getExtradesc() {
                return extradesc;
            }

            public String getIcon() {
                return icon;
            }

            public String getImg1() {
                return img1;
            }

            public String getImg2() {
                return img2;
            }

            public String getImg3() {
                return img3;
            }

            public String getLat() {
                return lat;
            }

            public String getLang() {
                return lang;
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

    public static class HostEntity {
        private String hostid;
        private String hostname;
        private String address;
        private String mobno;
        private String desc;
        private String lat;
        private String lang;
        private Object hostpic;

        public void setHostid(String hostid) {
            this.hostid = hostid;
        }

        public void setHostname(String hostname) {
            this.hostname = hostname;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public void setMobno(String mobno) {
            this.mobno = mobno;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public void setLat(String lat) {
            this.lat = lat;
        }

        public void setLang(String lang) {
            this.lang = lang;
        }

        public void setHostpic(Object hostpic) {
            this.hostpic = hostpic;
        }

        public String getHostid() {
            return hostid;
        }

        public String getHostname() {
            return hostname;
        }

        public String getAddress() {
            return address;
        }

        public String getMobno() {
            return mobno;
        }

        public String getDesc() {
            return desc;
        }

        public String getLat() {
            return lat;
        }

        public String getLang() {
            return lang;
        }

        public Object getHostpic() {
            return hostpic;
        }
    }
}
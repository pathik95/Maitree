package example.com.maitreev2.Response;

import java.util.List;

/**
 * Created by Hello on 11-02-2016.
 */
public class ResponsePlaceDetails {

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

    private List<PlaceEntity> Place;

    public void setPlace(List<PlaceEntity> Place) {
        this.Place = Place;
    }

    public List<PlaceEntity> getPlace() {
        return Place;
    }

    public static class PlaceEntity {
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
}

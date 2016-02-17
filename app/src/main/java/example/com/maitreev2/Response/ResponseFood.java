package example.com.maitreev2.Response;

import java.util.List;

/**
 * Created by Hello on 17-02-2016.
 */
public class ResponseFood {


    /**
     * foodid : 1
     * foodname : food1
     * foodat : food place 1
     * fooddesc : food decription containas infromation of the food which name was selested asdas sa asdsasa
     * lat : 10.012
     * lang : 10.0134
     * icon : http://10.0.2.2/maitree/images/food11.jpg
     * image1 : http://10.0.2.2/maitree/images/food12.jpg
     * image2 : http://10.0.2.2/maitree/images/food13.jpg
     * image3 : http://10.0.2.2/maitree/images/food14.jpg
     */

    private List<FoodEntity> Food;

    public void setFood(List<FoodEntity> Food) {
        this.Food = Food;
    }

    public List<FoodEntity> getFood() {
        return Food;
    }

    public static class FoodEntity {
        private String foodid;
        private String foodname;
        private String foodat;
        private String fooddesc;
        private String lat;
        private String lang;
        private String icon;
        private String image1;
        private String image2;
        private String image3;

        public void setFoodid(String foodid) {
            this.foodid = foodid;
        }

        public void setFoodname(String foodname) {
            this.foodname = foodname;
        }

        public void setFoodat(String foodat) {
            this.foodat = foodat;
        }

        public void setFooddesc(String fooddesc) {
            this.fooddesc = fooddesc;
        }

        public void setLat(String lat) {
            this.lat = lat;
        }

        public void setLang(String lang) {
            this.lang = lang;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public void setImage1(String image1) {
            this.image1 = image1;
        }

        public void setImage2(String image2) {
            this.image2 = image2;
        }

        public void setImage3(String image3) {
            this.image3 = image3;
        }

        public String getFoodid() {
            return foodid;
        }

        public String getFoodname() {
            return foodname;
        }

        public String getFoodat() {
            return foodat;
        }

        public String getFooddesc() {
            return fooddesc;
        }

        public String getLat() {
            return lat;
        }

        public String getLang() {
            return lang;
        }

        public String getIcon() {
            return icon;
        }

        public String getImage1() {
            return image1;
        }

        public String getImage2() {
            return image2;
        }

        public String getImage3() {
            return image3;
        }
    }
}

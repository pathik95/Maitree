package example.com.maitreev2.Response;

import java.util.List;

/**
 * Created by Hello on 11-02-2016.
 */
public class ResponseHost {

    /**
     * hostid : 1
     * hostname : Chirag Pandya
     * address : 41,Dipali Soc.,Near Madhuvrund soc ,Ghatlodia Ahmedabad
     * mobno : 9123435781
     * desc : Mr chirag pandya is a lecturar in ldrp college ,he is master in c, c++ languange he is working with maitree foundation since 2002  his father is also a member of maitree foundation
     * lat : 12.002
     * lang : 10.002
     * hostpic : null
     */

    private List<HostEntity> Host;

    public void setHost(List<HostEntity> Host) {
        this.Host = Host;
    }

    public List<HostEntity> getHost() {
        return Host;
    }

    public static class HostEntity {
        private String hostid;
        private String hostname;
        private String address;
        private String mobno;
        private String desc;
        private String lat;
        private String lang;
        private String hostpic;

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

        public void setHostpic(String hostpic) {
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

        public String getHostpic() {
            return hostpic;
        }
    }
}

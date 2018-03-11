package cn.itcast.mybatis.model;

public class IdCard {
    private String cardId;
    private String province;
    private String city;
    private Integer usserid;

    public String getCardId() {
        return cardId;
    }

    public String getProvince() {
        return province;
    }

    public String getCity() {
        return city;
    }

    public Integer getUsserid() {
        return usserid;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setUsserid(Integer usserid) {
        this.usserid = usserid;
    }

    @Override
    public String toString() {
        return "IdCard{" +
                "cardId='" + cardId + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", usserid=" + usserid +
                '}';
    }
}

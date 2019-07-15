package cyl.simpledatastruc.model;

/**
 * @author chengyuanliang
 * @desc
 * @since 2019-06-24
 */

public class UserInfoModel {

    private String name;

    private Integer age;

    private String sex;

    private String position;

    private String address;

    private String hobby;

    private String attr;

    public UserInfoModel() {
    }

    private UserInfoModel(String name) {
        this.name = name;
    }

    public UserInfoModel(String name, Integer age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;

    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    private  void printAllFiled() {
        System.out.println("printAllFiled" + this.name);
    }

    @Override
    public String toString() {
        return "UserInfoModel{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", position='" + position + '\'' +
                ", address='" + address + '\'' +
                ", hobby='" + hobby + '\'' +
                '}';
    }
}

package model;

public class Heros {

    private int id;
    private String name;
    private String realName;
    private String superPowers;
    private String avatars;

    public Heros(int id, String name, String realName, String superPowers, String avatars) {
        this.id = id;
        this.name = name;
        this.realName = realName;
        this.superPowers = superPowers;
        this.avatars = avatars;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getSuperPowers() {
        return superPowers;
    }

    public void setSuperPowers(String superPowers) {
        this.superPowers = superPowers;
    }

    public String getAvatars() {
        return avatars;
    }

    public void setAvatars(String avatars) {
        this.avatars = avatars;
    }

    @Override
    public String toString() {
        return "Heros{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", realName='" + realName + '\'' +
                ", superPowers='" + superPowers + '\'' +
                ", avatars='" + avatars + '\'' +
                '}';
    }
}
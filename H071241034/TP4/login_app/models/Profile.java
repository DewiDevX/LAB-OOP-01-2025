package login_app.models;

public class Profile {
    private String fullName;  // Nama lengkap user
    private String nickName;  // Nickname dari fullName (kata ke-2)
    private int age;          // Umur user
    private String hobby;     // Hobi user

    // Constructor kosong karena field diisi satu-satu di Main.java
    public Profile() {}

    // Setter & Getter untuk fullName
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    // Setter & Getter untuk nickName
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getNickName() {
        return nickName;
    }

    // Setter & Getter untuk age
    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    // Setter & Getter untuk hobby
    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getHobby() {
        return hobby;
    }
}

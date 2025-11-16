package model;

//Karimah Irsyadiyah
//2411533018

public class User {
    String id, nama, username, password;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Method login
    public static boolean login(String username, String password) {
        boolean isLoggin = false;

        User user = new User();
        user.setId("1");
        user.setNama("ima");
        user.setUsername("ima");
        user.setPassword("12345");

  
        String cleanUsername = username.replaceAll("\\s+", "").toLowerCase();
        String cleanPassword = password.trim();

     
        String dbUsername = user.getUsername().replaceAll("\\s+", "").toLowerCase();
        String dbPassword = user.getPassword().trim();


        if (dbUsername.equals(cleanUsername) && dbPassword.equals(cleanPassword)) {
            isLoggin = true;
        } else {
            isLoggin = false;
        }

        return isLoggin;
    }
}

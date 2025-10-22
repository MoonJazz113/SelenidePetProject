package Api;

public class UserCreate {
    public String name;
    public String job;

    public UserCreate(String name, String job) {
        this.name = name;
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }
}

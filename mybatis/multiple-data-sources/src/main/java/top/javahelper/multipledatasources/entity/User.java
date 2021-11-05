package top.javahelper.multipledatasources.entity;

/**
 * @description:
 * @projectName:multiple-data-sources
 * @see:top.javahelper.multipledatasources.entity
 * @author:郑晓龙
 * @createTime:2021/11/5 9:07
 * @version:1.0
 */
public class User {
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

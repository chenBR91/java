public class File {
    private String name;
    private String type;

    public File(String name, String type) {
        setName(name);
        this.type = type;
    }

    private void setName(String name) throws IllegalArgumentException{
        if(name.isEmpty())
            throw new IllegalArgumentException("file name is empty");
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

}

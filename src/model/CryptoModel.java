package model;

public class CryptoModel {
    private int key;
    private String pathFrom;
    private String pathTo;
    private String pathExample;

    public CryptoModel(int key, String pathFrom, String pathTo) {
        this.key = key;
        this.pathFrom = pathFrom;
        this.pathTo = pathTo;
    }

    public CryptoModel(String pathFrom, String pathTo, String pathExample) {
        this.pathExample = pathExample;
        this.pathFrom = pathFrom;
        this.pathTo = pathTo;
    }

    public CryptoModel() {

    }


    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getPathFrom() {
        return pathFrom;
    }

    public void setPathFrom(String pathFrom) {
        this.pathFrom = pathFrom;
    }

    public String getPathTo() {
        return pathTo;
    }

    public void setPathTo(String pathTo) {
        this.pathTo = pathTo;
    }

    public String getPathExample() {
        return pathExample;
    }

    public void setPathExample(String pathExample) {
        this.pathExample = pathExample;
    }
}


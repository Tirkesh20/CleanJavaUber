package command;

public class Page {
  private   String Url;
  private boolean redirecet;


    public void setRedirecet(boolean redirecet) {
        this.redirecet = redirecet;
    }

    public boolean isRedirecet() {
        return redirecet;
    }

    public String getUrl() {
        return Url;
    }

    public  void setUrl(String url) {
        Url = url;
    }
}

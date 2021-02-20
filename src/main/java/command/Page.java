package command;

public class Page {
  private   String Url;
  private boolean redirect;


    public void setRedirect(boolean redirect) {
        this.redirect = redirect;
    }
    public boolean isRedirect() {
        return redirect;
    }

    public String getUrl() {
        return Url;
    }

    public  void setUrl(String url) {
        Url = url;
    }
}

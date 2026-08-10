package Library_Catalogue;

public abstract class LibraryItemBase implements LibraryItem {

    private String shelfCode;

    public String getShelfCode() {
        return shelfCode;
    }

    public void setShelfCode(String shelfCode) {
        this.shelfCode = shelfCode;
    }

    @Override
    public abstract void printAllInfo();

    @Override
    public abstract String getLabel();
}


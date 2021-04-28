package model;

public class Book {
    private Page[] pages;
    private Integer pagecount;

    public Book(Integer pagecount) {
        if (pagecount < 0) {
            throw new IllegalArgumentException("Illegal pagecount param!");
        }
        Page[] pages = new Page[pagecount];
        for (int i = 0; i < pagecount; i++) {
            pages[i] = new Page(true);
        }
        this.pages = pages;
        this.pagecount = pagecount;
    }

    public void pulloutPage(Integer pagecount) {
        if (pagecount < 0 || pagecount > this.pagecount) {
            throw new IllegalArgumentException("Illegal pagecount param!");
        }

        this.pages[pagecount].setPresent(false);
    }

    public Page getPage(Integer pagecount) {
        if (pagecount < 0 || pagecount > this.pagecount) {
            throw new IllegalArgumentException("Illegal pagecount param!");
        }

        return this.pages[pagecount];
    }

    public Integer getPagecount() {
        return pagecount;
    }
}

package de.adesso.gitstalker.core.resources.team_Resources;

public class PageInfo {

    private boolean hasNextPage;
    private String endCursor;

    public PageInfo() {}

    public boolean isHasNextPage() {
        return hasNextPage;
    }

    public String getEndCursor() {
        return endCursor;
    }

}

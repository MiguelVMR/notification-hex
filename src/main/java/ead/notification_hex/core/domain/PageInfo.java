package ead.notification_hex.core.domain;

/**
 * The Class PageInfo
 *
 * @author Miguel Vilela Moraes Ribeiro
 * @since 01/05/2025
 */
public class PageInfo {

    private int pageNumber;
    private int pageSize;

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}

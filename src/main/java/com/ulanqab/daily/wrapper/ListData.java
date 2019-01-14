package com.ulanqab.daily.wrapper;

import java.io.Serializable;
import java.util.List;

public class ListData<T> implements Serializable {
    private static final long serialVersionUID = 8324798729516352370L;

    private boolean hasMore;

    private List<T> list;

    public ListData(boolean hasMore, List<T> list) {
        this.hasMore = hasMore;
        this.list = list;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public boolean isHasMore() {
        return hasMore;
    }

    public void setHasMore(boolean hasMore) {
        this.hasMore = hasMore;
    }
}

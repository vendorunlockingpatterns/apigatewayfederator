package org.vendorunlockingpatterns.apigatewayfederator.pagination;

import java.util.List;
import java.util.function.Function;

public interface PagedResult<T> {

	public Integer getLimit();

	public Integer getOffset();

	public String getNextPageId();

	public Long getCount();

	public List<T> getContent();

	public boolean isLastPage();

	public <R> PagedResult<R> mapContent(Function<T, R> mapper);
}

package org.vendorunlockingpatterns.apigatewayfederator.pagination;

import javax.ws.rs.core.MultivaluedMap;

public interface PaginationContext {

	public Integer getOffset();

	public Integer getLimit();

	public String getNextPageId();

	public void init(MultivaluedMap<String, String> queryParams);

	public default int getActualLimit(long count, int maxLimit) {
		return (int) Math.min(getActualLimit(maxLimit), count);
	}

	public default int getActualLimit(int maxLimit) {
		return (getLimit() == null || getLimit() > maxLimit) ? maxLimit : getLimit();
	}

	public default int getActualOffset() {
		return getOffset() == null ? 0 : getOffset();
	}
}

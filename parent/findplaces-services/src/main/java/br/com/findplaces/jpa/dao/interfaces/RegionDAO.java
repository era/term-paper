package br.com.findplaces.jpa.dao.interfaces;

import br.com.findplaces.jpa.entity.geographic.Region;

public interface RegionDAO extends BaseDAO<Region, Long> {

	Region findByName(String name);
	Region findByAlias(String alias);
}

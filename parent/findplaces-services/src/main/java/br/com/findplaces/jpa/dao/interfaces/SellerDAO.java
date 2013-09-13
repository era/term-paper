package br.com.findplaces.jpa.dao.interfaces;

import br.com.findplaces.jpa.entity.Seller;

public interface SellerDAO extends BaseDAO<Seller, Long> {

	Seller findSellerByUserSocialId(String socialid);

}

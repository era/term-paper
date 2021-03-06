package br.com.findplaces.jpa.dao.interfaces;

import java.util.List;

import br.com.findplaces.jpa.entity.Likes;
import br.com.findplaces.jpa.entity.Seller;
import br.com.findplaces.jpa.entity.Token;
import br.com.findplaces.jpa.entity.User;

public interface UserDAO extends BaseDAO<User, Long> {

	Token findToken(String token, Long userID);
	
	void saveToken(Token token);
	
	User findUserBySocialID(String id);
	
	void saveLikesFromUser(List<Likes> likes);
	
	void saveLikesFromUser(Likes likes);
	
	User findUserByEmailAndPassword(String email, String password);
	
	Seller saveSellerConfigurations(Seller seller);

	Seller findSellerBySocialID(String socialID);
	
	Seller findSellerByUserID(Long id);

	void deleteToken(Token token);
	
}

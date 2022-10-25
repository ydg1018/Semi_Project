package faq.dao.face;

import java.sql.Connection;
import java.util.List;

import faq.dto.FaQ;

public interface FaqDao {

	List<FaQ> selectAll(Connection conn);

}

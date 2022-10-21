package reservation.dao.face;

import java.sql.Connection;

import hosInfo.dto.HosInfo;

public interface ReservationDao {

	/**
	 * 지정된 hosCode를 이용하여 병원 조회하기
	 * 
	 * @param conn - DB 연결 객체
	 * @param hosCode - 조회할 병원의 HosCode
	 * @return HosInfo
	 */
	public HosInfo selectHosByHosCode(Connection conn, HosInfo hosCode);

}

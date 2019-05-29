package org.shaqueim.trust;

import java.time.LocalDateTime;
import java.util.Date;

import org.apache.commons.math3.util.Precision;

import com.shaqueim.trust.Configurations;

/**
 *
 * @author Shaqueim Cameron cameronofficial.org
 */
public class TrustUtils {
    
	
	public static long getUnixTimeStamp(int dd, int mm, int yy) {
		if(yy < 32) {
			yy += 2000;
		}
		
		return TrustUtils.toUnixTimeStamp(LocalDateTime.of(yy, mm, dd, 12, 0));
	}
	public static long toUnixTimeStamp(LocalDateTime date) {
		return date.toEpochSecond(Configurations.getZoneOffset());
	}
	
	public static LocalDateTime fromUnixTimeStamp(long unix) {
		return LocalDateTime.ofEpochSecond(unix, 0, Configurations.getZoneOffset());
	}
	
	public static long toUnixTimeStamp(long t) {
		return (long) Precision.round(t/1000, 0);
	}

	public static String formatDate(LocalDateTime date) {
		return date.format(Configurations.getDateTimeFormat());
	}
	
}

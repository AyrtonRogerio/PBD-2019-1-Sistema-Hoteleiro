/**
 * 
 */
package br.com.sistemahoteleiro.util;

import java.sql.Time;
import java.time.LocalTime;

import javax.persistence.AttributeConverter;

/**
 * @author ayrtons
 *
 */
public class ConverterLocalTime implements AttributeConverter<LocalTime, Time>{

	@Override
	public Time convertToDatabaseColumn(LocalTime arg0) {
		// TODO Auto-generated method stub
		return Time.valueOf(arg0);
	}

	@Override
	public LocalTime convertToEntityAttribute(Time arg0) {
		// TODO Auto-generated method stub
		return arg0.toLocalTime();
	}

}

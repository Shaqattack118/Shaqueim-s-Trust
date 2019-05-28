package com.shaqueim.trust;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.ZoneOffset;
import java.util.ArrayList;

import org.shaqueim.trust.TrustUtils;
import org.shaqueim.trust.entity.Entity;
import org.shaqueim.trust.loan.Loan;
import org.shaqueim.trust.loan.payment.Payment;

public class SystemsController {
	private static final int TIMEZONE = -5;
	private static ZoneOffset offset = ZoneOffset.ofHours(TIMEZONE);
	private static ArrayList<Payment> payments = new ArrayList<Payment>();

	private static String generatePaymentString() {
		StringBuilder pmtS = new StringBuilder();
		payments.forEach((pmt) -> {
			// int index = payments.indexOf(pmt);
			int loanId = pmt.getLoanIdentifier();
			double totalPaid = pmt.getInterestPaid() + pmt.getPrincipalOverpayment() + pmt.getPrincipalPaid();
			long unix = TrustUtils.toUnixTimeStamp(pmt.getDate());
			pmtS.append(loanId + " " + totalPaid + " " + unix + "\n");
		});

		return pmtS.toString();
	}

	private static ArrayList<Entity> entities = new ArrayList<Entity>();

	public static int entitiesExist(int... ents) {
		for (int i : ents) {
			if (entities.get(i) == null) {
				return i;
			}
		}
		return -1;
	}

	public static Entity getEntity(int id) {
		return entities.get(id);
	}

	public static boolean entityExists(Entity e) {
		return entities.indexOf(e) != -1;
	}

	public static int addEntity(Entity e) {
		entities.add(e);
		return entities.indexOf(e);
	}

	private static ArrayList<Loan> loans = new ArrayList<Loan>();

	public static int addLoan(Loan l) {
		loans.add(l);
		return loans.indexOf(l);
	}

	public static void addLoan(int identifier, Loan l) {
		loans.add(identifier, l);
	}

	public static Loan getLoanForIdentifier(int identifier) {
		return loans.get(identifier);
	}

	public static int getIdentifierForLoan(Loan l) {
		return loans.indexOf(l);
	}

	public static void loadPayments() {

		/*
		 * LocalDateTime date = LocalDateTime.now();
		 * 
		 * for(int i = 0; i < 4; i++) {
		 * System.out.println("1 16000 "+date.toEpochSecond(offset)); date =
		 * date.minusMonths(1); }
		 */

		if (!Configurations.PAYMENT_DATA.exists()) {
			savePayments();
		}
		FileInputStream fin = null;
		byte[] contents = null;
		try {
			fin = new FileInputStream(Configurations.PAYMENT_DATA);
			contents = new byte[(int) Configurations.PAYMENT_DATA.length()];
			fin.read(contents);
			fin.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		String[] paymentStrings = new String(contents).split("\n");
		for (String paymentString : paymentStrings) {
			Payment pmt = parsePaymentString(paymentString);
			payments.add(pmt);
		}

		payments.sort(null);
		System.out.println(payments.toString());

	}

	public static void savePayments() {

		try {
			FileOutputStream fos = new FileOutputStream(Configurations.PAYMENT_DATA);
			fos.write(generatePaymentString().getBytes());
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static Payment parsePaymentString(String paymentString) {
		String[] paymentSections = paymentString.split(" ");
		return new Payment(Integer.parseInt(paymentSections[0]),
				TrustUtils.fromUnixTimeStamp(Long.parseLong(paymentSections[2])),
				Double.parseDouble(paymentSections[1]));
	}
}

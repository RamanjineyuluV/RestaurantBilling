package com.restaurantbilling.calcs.impl;

import com.restaurantbilling.calcs.CalcUtil;
import com.restaurantbilling.constants.Constants;

public class DiscountUtil implements CalcUtil{

	private final int subtotal;

	public int getSubtotal() {
		return subtotal;
	}

	public DiscountUtil(int subtotal) {
		this.subtotal = subtotal;
	}

	public int doCalcs() {
		if (subtotal <= Constants.TWO_THOUSAND) {
			return Constants.ZERO;
		}

		if (subtotal <= Constants.FIVE_THOUSAND) {
			return (int) ((subtotal - Constants.TWO_THOUSAND) * Constants.TEN_PERCENT);
		}

		if (subtotal <= Constants.TEN_THOUSAND) {
			return (int) (Constants.THREE_HUNDRED + ((subtotal - Constants.FIVE_THOUSAND) * Constants.TWENTY_PERCENT));
		}

		return (int) (Constants.THREE_HUNDRED + Constants.THOUSAND
				+ ((subtotal - Constants.TEN_THOUSAND) * Constants.THIRTY_PERCENT));

	}
}

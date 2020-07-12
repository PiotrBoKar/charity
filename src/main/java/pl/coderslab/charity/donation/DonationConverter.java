package pl.coderslab.charity.donation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class DonationConverter implements Converter<String, Donation> {
    @Autowired
    private DonationDao donationDao;

    @Override
    public Donation convert(String source) {
        return donationDao.find(Long.parseLong(source));
    }
}
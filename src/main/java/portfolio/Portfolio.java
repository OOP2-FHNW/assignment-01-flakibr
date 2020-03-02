package portfolio;

import portfolio.investments.Investment;

import java.util.ArrayList;
import java.util.List;

public class Portfolio<T extends Investment> {
    private List<T> investments = new ArrayList<>();

    public boolean contains(T investment) {
        String title = investment.getTitel();
        for (T i : investments) {
            if (i.getTitel().equals(title)) return true;
        }
        return false;
    }

    public void buy(T investment) {
        String title = investment.getTitel();
        T i = getShare(investment.getTitel());
        if (i == null) investments.add(investment);
        else i.setCount(i.getCount() + investment.getCount());
    }

    public void sell(String investmentName, int count) {
        Investment i = getShare(investmentName);
        if (i == null) return;
        double newCount = i.getCount() - count;
        if (newCount <= 0) {
            investments.remove(i);
            i.setCount(0);
        } else {
            i.setCount(newCount);
        }
    }

    public T getShare(String investmentName) {
        for (T investment : investments) {
            if (investment.getTitel().equals(investmentName)) {
                return investment;
            }
        }
        return null;
    }
}

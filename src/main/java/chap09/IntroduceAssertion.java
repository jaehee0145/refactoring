package chap09;


import org.junit.Assert;

public class IntroduceAssertion {
    class Employee {
        private static final double NULL_EXPENSE = -1.0;
        private double expenseLimit = NULL_EXPENSE;
        private Project primaryProject;
        double getExpenseLimit() {
            Assert.assertTrue(expenseLimit != NULL_EXPENSE || primaryProject != null);
            return expenseLimit != NULL_EXPENSE ? expenseLimit : primaryProject.getMemberExpenseLimit();
        }
        boolean withinLimit (double expenseAmount) {
            return expenseAmount <= getExpenseLimit();
        }
    }

    private class Project {
        public double getMemberExpenseLimit() {
            return 0;
        }
    }
}

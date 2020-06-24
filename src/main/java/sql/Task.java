package sql;

public class Task {
    private final String query1 = "SELECT city, MAX(grade) FROM customer\n"
            + "GROUP BY city";
    private final String query2 = "SELECT customer_id, ord_date, MAX(purch_amt) as max_purch_amt"
            + " FROM orders\n"
            + "GROUP BY customer_id, ord_date";
    private final String query3 = "SELECT customer_id, ord_date, MAX(purch_amt) as max_purch_amt"
            + " FROM orders\n"
            + "GROUP BY customer_id, ord_date\n"
            + "HAVING MAX(purch_amt) BETWEEN 2000 and 6000\n";
    private final String query4 = "SELECT cust_name, customer.city, salesman.name, commission "
            + "FROM customer \n"
            + "LEFT JOIN salesman ON customer.salesman_id = salesman.salesman_id\n"
            + "WHERE salesman.commission > 0.12";
    private final String query5 = "SELECT cust_name, customer.city, grade,"
            + "salesman.name AS salesman, salesman.city as salesmans_city FROM customer\n"
            + "LEFT JOIN salesman ON customer.salesman_id = salesman.salesman_id\n"
            + "ORDER BY cust_name\n";
    private final String query6 = "SELECT cust_name, city, grade FROM customer\n"
            + "WHERE grade < 300\n"
            + "ORDER BY grade";
    private final String query7 = "SELECT dpt_name\n"
            + "FROM emp_department AS e_dep\n"
            + "LEFT JOIN emp_details AS e_det\n"
            + "ON e_dep.dpt_code = e_det.emp_dept\n"
            + "GROUP BY dpt_name\n"
            + "HAVING COUNT(*) > 2";
}

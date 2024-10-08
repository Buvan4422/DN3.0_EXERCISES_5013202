CREATE DEFINER=`root`@`localhost` PROCEDURE `GenerateMonthlyStatements`()
BEGIN
    DECLARE done INT DEFAULT FALSE;
    DECLARE cur_customer_id INT;
    DECLARE cur_name VARCHAR(255);
    DECLARE cur_account_id INT;
    DECLARE cur_transaction_date DATE;
    DECLARE cur_amount DECIMAL(10, 2);
    DECLARE cur_transaction_type VARCHAR(50);

    DECLARE cur1 CURSOR FOR 
        SELECT c.CustomerID, c.Name, t.AccountID, t.TransactionDate, t.Amount, t.TransactionType
        FROM Customers c
        JOIN Accounts a ON c.CustomerID = a.CustomerID
        JOIN Transactions t ON a.AccountID = t.AccountID
        WHERE MONTH(t.TransactionDate) = MONTH(CURDATE()) AND YEAR(t.TransactionDate) = YEAR(CURDATE());

    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;

    OPEN cur1;

    read_loop: LOOP
        FETCH cur1 INTO cur_customer_id, cur_name, cur_account_id, cur_transaction_date, cur_amount, cur_transaction_type;
        IF done THEN
            LEAVE read_loop;
        END IF;

        SELECT CONCAT('Customer: ', cur_name, ' (ID: ', cur_customer_id, ') - Account: ', cur_account_id, ' - Date: ', cur_transaction_date, ' - Amount: ', cur_amount, ' - Type: ', cur_transaction_type) AS Statement;
    END LOOP;

    CLOSE cur1;
END
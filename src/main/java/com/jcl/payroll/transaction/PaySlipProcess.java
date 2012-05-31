/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcl.payroll.transaction;

 
 
//import com.jcl.dbms.dbms;
import com.jcl.model.PayrollPeriod;
import com.jcl.model.PaySlip;
import com.jcl.model.PaySlipDetail;
import com.jcl.model.Employee;  
import com.jcl.payroll.dtr.DailyTimeRecord;
import com.jcl.payroll.enumtypes.DTRType;
import com.jcl.payroll.enumtypes.PayrollPeriodStatus;
import com.jcl.payroll.enumtypes.PayrollPeriodType;
import com.jcl.utilities.MyDateFormatter;
import com.jcl.utilities.MyNumberFormatter;
import com.jcl.utilities.TransactionException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jlavador
 */
public class PaySlipProcess {
public static List<Employee> preparePayslip(Long payrollPeriodID, Employee eep) throws Exception {

        System.out.println("processPayslip: " + payrollPeriodID + " employee: " + eep);
        List<Employee> employeeList = new ArrayList<Employee>();

//        PayrollPeriod pp = PayrollPeriod.getPayrollPeriodByTid(payrollPeriodID);
//        LinkedHashMap<Integer, Employee> emplist = new LinkedHashMap<Integer, Employee>();
//        if (pp.getStatus().equals(PayrollPeriodStatus.Generated.name())) {
//            //note: if the status of the payroll period is generated, make sure the process will not run
//            //just retrieve al payslip from the database, this is not tested 03-02-2011
//            List<Employee> empList2 = Employee.getEmployees(PayrollPeriodType.valueOf(pp.getPayrollPeriodType()));
//            LinkedHashMap<Integer, PaySlip> paySlipList = PaySlip.getPayslipByEmployee(pp, null);
//            System.out.println("paysliplist count: " + paySlipList.size());
//            for (Employee e : empList2) {
//                e.payslip = paySlipList.get(e.getTid());
//                emplist.put(e.getTid(), e);
//            }
//
//        } else {
//            emplist = PaySlipProcess.processPayslip(pp, eep);
//        }
//
//
//        for (Employee emp : emplist.values()) {
//
//
//            PaySlipReportObject psro = new PaySlipReportObject();
//            psro.setEmployeeTid(emp.getTid());
//
//            System.out.println(emp.payslip.getPayrollPeriod().getPayrollPeriodCode());
//
//            double totalAdd = 0;
//            int row = 1;
//            for (PaySlipDetail psd : emp.payslip.getPayables()) {
//                PaySlipReportRow psrr = new PaySlipReportRow();
//                psrr.setRow(row++);
//                String psdString =createPayslipDetailDescription(psd);
//                psrr.setDescription(psdString);
//                psrr.setEmployeeName("Name: " + emp.getName());
//
//                psrr.setPosition(emp.getPosition().getDescription());
//                if(psd.isIsDeduction()){
//                    psrr.setAmount(psd.getTotal()* -1);
//                }else{
//                    psrr.setAmount(psd.getTotal());
//                }
//                psro.getList().add(psrr);
//                totalAdd = totalAdd + psd.getTotal();
//                System.out.println(psd.getRowNumber() + "     " + psd.getDescription() + " " + psd.getTotal());
//            }
//
//            double totalLess = 0;
//            for (PaySlipDetail psd : emp.payslip.getReceivables()) {
//
//                PaySlipReportRow psrr = new PaySlipReportRow();
//                psrr.setRow(row++);
//                String psdString =createPayslipDetailDescription(psd);
//                psrr.setDescription(psdString);
//                psrr.setEmployeeName(emp.getName());
//                psrr.setPosition(emp.getPosition().getDescription());
//                  if(psd.isIsDeduction()){
//                    psrr.setAmount(psd.getTotal()* -1);
//                }else{
//                    psrr.setAmount(psd.getTotal());
//                }
//                psro.getList().add(psrr);
//
//                totalLess = totalLess + psd.getTotal();
//
//                System.out.println(psd.getRowNumber() + "     " + psd.getDescription() + " " + psd.getTotal());
//            }
//            psro.setNetTotal(totalAdd - totalLess);
//            emp.payslipReport = psro;
//
//            employeeList.add(emp);
//
//        }



        return employeeList;
    }

    public static List<DailyTimeRecord> retreiveDTR(Date fromDate, Date toDate, Employee employee) throws  TransactionException, Exception {

//        int transCount = 0;
//        SimpleDateFormat sdf = MyDateFormatter.getYearDateKeyFormatter();
//        System.out.println("retrieving dtr.");
//        Query query = dbms.getDBInstance().query();
//        query.constrain(DailyTimeRecord.class);
//
//        Constraint c1 = query.descend("date").constrain(toDate).smaller();
//        Constraint c2 = query.descend("date").constrain(toDate).or(c1);
//        Constraint c3 = query.descend("date").constrain(fromDate).greater();
//        Constraint c4 = query.descend("date").constrain(fromDate).or(c3);
//
//        query.descend("employeeId").constrain(employee.getTid());
//        query.descend("date").orderAscending();
//
//        ObjectSet<DailyTimeRecord> list = query.execute();
//
//        List<DailyTimeRecord> theList = new ArrayList<DailyTimeRecord>();
//        Set<Integer> truckingIDList = new HashSet<Integer>();
//        for (DailyTimeRecord dtr : list) {
//            theList.add(dtr);
//            if(dtr.getSourceTid()!= -1){
//                truckingIDList.add(dtr.getSourceTid());
//            }
//        }
//
//
//        // trucking information
//        List<Trucking> truckingList = Trucking.getTrucking(" ", fromDate, toDate, InvoiceType.Trucking);
//        System.out.println("trucking: " + truckingList.size());
//        for (Trucking trucking : truckingList) {
//
//            if(truckingIDList.contains(trucking.getTid()))
//               continue;
//            
//            for (TruckingEmployee emp : trucking.getTruckingEmployees()) {
//                System.out.println(emp.getEmployeeTid() + ":" + employee.getTid());
//
//                if (emp.getEmployeeTid() == employee.getTid()) {
//
//                    if (emp.getPositionTid() == 2) {
//                        theList.add(createDTR(emp.getEmployeeTid(), trucking, DTRType.Helper));
//                    } else {
//                        theList.add(createDTR(emp.getEmployeeTid(), trucking, DTRType.Loading));
//                    }
//
//
//                }
//            }
//            System.out.println("Driver: " + trucking.getDriver() + " : " + trucking.getDriverName());
//            if (trucking.getDriver() != null) {
//                theList.add(createDTR(trucking.getDriver().getTid(), trucking, DTRType.Drive));
//            }
//        }
//
//        String msg = "";
//
//        return theList;
        return null;
    }

//    public static DailyTimeRecord createDTR(int employeeId, Trucking trucking, DTRType dtrtype) {
//        DailyTimeRecord dtr = new DailyTimeRecord(employeeId);
//        try {
//
//            SimpleDateFormat sdf2 = MyDateFormatter.getDateTimeFormatter();
//            String wdate = MyDateFormatter.getDateDataFormatter().format(trucking.getTransactionDate());
//            Date t1 = sdf2.parse(wdate + " " + WorkShift.TIME_IN1);
//            Date t2 = sdf2.parse(wdate + " " + WorkShift.TIME_OUT1);
//            Date t3 = sdf2.parse(wdate + " 00:00:00 PM");
//            Date t4 = sdf2.parse(wdate + " 00:00:00 PM");
//            System.out.println("trucking.getNumber(): " + trucking.getNumber());
//            dtr.setReference(trucking.getNumber());
//            dtr.setDate(trucking.getTransactionDate());
//            dtr.setNotes(trucking.getNumber());
//            if (trucking.getArrival().length() > 0 && trucking.getDeparture().length() > 0) {
//                try {
//                    String departure = trucking.getDeparture();
//                    if (trucking.getDeparture().indexOf("AM") > 0) {
//                        String am = departure.replaceAll("AM", " ").trim();
//                        departure = am + ":00 AM";
//                    } else if (trucking.getDeparture().indexOf("PM") > 0) {
//                        String pm = departure.replaceAll("PM", " ").trim();
//                        departure = pm + ":00 PM";
//                    }
//                    String arrival = trucking.getArrival();
//                    if (trucking.getArrival().indexOf("AM") > 0) {
//                        String am = arrival.replaceAll("AM", " ").trim();
//                        arrival = am + ":00 AM";
//                    } else if (trucking.getArrival().indexOf("PM") > 0) {
//                        String pm = arrival.replaceAll("PM", " ").trim();
//                        arrival = pm + ":00 PM";
//                    }
//                    System.out.println(arrival + " : " + departure);
//                    t1 = sdf2.parse(wdate + " " + departure);
//                    t2 = sdf2.parse(wdate + " " + arrival);
//                    dtr.setNotes(trucking.getNumber());
//                } catch (Exception ex) {
//                    dtr.setNotes("Error parsing time. using default.");
//                }
//            }
//            dtr.setDtrType(dtrtype.name());
//            dtr.setSourceTid(trucking.getTid());
//            dtr.setTimeIn1(t1);
//            dtr.setTimeOut1(t2);
//            dtr.setTimeIn2(t3);
//            dtr.setTimeOut2(t4);
//            dtr.setIsDTR(false);
//            dtr.setNoOfEmployeeSharing(trucking.computeNumberOfLoader());
//
//        } catch (ParseException ex) {
//            Logger.getLogger(PaySlipProcess.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return dtr;
//    }

    /**
     * 1. get all employee with payroll period type (variable, semimonthly, weekly, );
     * 2. retrieve all dtr loop and create entries
     * 3. retrieve all trucking and loops on employeedetails and create dtr entries 
     *    get trucking driver and create dtr entries.
     * 4. while looping on employee details. compute rates on
     * still in question adding new fields in DTR , rates,
     *
     *
     * 5. this will create payments for cashadvanced and loans we can combined
     *    payments for cashadvances and loans into a single transacation
     *    "check filter transaction and figure out how to filter payments for generated
     *    billing transaction.
     * @param fromDate
     * @param toDate
     * @param ppt
     */
    public static LinkedHashMap<Long, Employee> processDTRforPayroll(PayrollPeriod pp, Employee eep) throws Exception {
        System.out.println("payslipinformation x.2");
        LinkedHashMap<Long, Employee> empList = new LinkedHashMap<Long, Employee>();
//        LinkedHashMap<Integer, PaySlip> payslipList = PaySlip.getPayslipByEmployee(pp, eep);
//        List<Employee> listPP = new ArrayList<Employee>();
//        if (eep == null) {
//            System.out.println("payslipinformation x.2.1");
//            listPP = Employee.getEmployees(PayrollPeriodType.valueOf(pp.getPayrollPeriodType()));
//        } else {
//            System.out.println("payslipinformation x.2.2");
//            listPP.add(eep);
//        }
//
//
//
//
//        System.out.println("listPP: " + listPP.size());
//        System.out.println("payslipList: " + payslipList.size());
//        for (Employee e : listPP) {
//            System.out.println("emplist: " + e.getTid());
//            e.dtrList = new ArrayList<DailyTimeRecord>();
//
//            PaySlip payslip = payslipList.get(e.getTid());
//            if (payslip == null) {
//                e.payslip = new PaySlip(e, pp);
//            } else {
//                payslip.setEmployee(e);
//                payslip.setPayrollPeriod(pp);
//            }
//            //      dbms.getDBInstance().activate(payslip, 1);
//
//            e.payslip = payslip;// payslipList.get(e.getTid());
//            empList.put(e.getTid(), e);
//        }
//
//        int transCount = 0;
//        SimpleDateFormat sdf = MyDateFormatter.getYearDateKeyFormatter();
//        System.out.println("retrieving dtr.");
//        Query query = dbms.getDBInstance().query();
//        query.constrain(DailyTimeRecord.class);
//
//        Constraint c1 = query.descend("date").constrain(pp.getDateTo()).smaller();
//        Constraint c2 = query.descend("date").constrain(pp.getDateTo()).or(c1);
//        Constraint c3 = query.descend("date").constrain(pp.getDateFrom()).greater();
//        Constraint c4 = query.descend("date").constrain(pp.getDateFrom()).or(c3);
//
//        if (eep != null) {
//            query.descend("employeeId").constrain(eep.getTid()).and(c4);
//        }
//
//        query.descend("date").orderAscending();
//
//        ObjectSet<DailyTimeRecord> list = query.execute();
//        System.out.println("DailyTimeRecord: " + list.size());
//
//        //retreive common or saved dtr
//        for (DailyTimeRecord dtr : list) {
//            Employee e = empList.get(dtr.getEmployeeId());
//            if (e == null) {
//                continue;
//            }
//
//            double rates = 0.0;
//            if (dtr.getDtrType().equals(DTRType.Helper.name())) {
//                rates = e.getAllowance();
//            } else if (dtr.getDtrType().equals(DTRType.Regular.name())) {
//                rates = e.getDailyRate();
//            } else if (dtr.getDtrType().equals(DTRType.Absence.name())) {
//                rates = -1 * e.getDailyRate();
//            }
//
//            dtr.setQuantity(1);
//            dtr.setAmount(rates);
//            dtr.setNoOfEmployeeSharing(1);
//            dtr.setNetAmount(rates);
//            e.dtrList.add(dtr);
//        }
//
//        List<Trucking> truckingList = Trucking.getTrucking(" ", pp.getDateFrom(), pp.getDateTo(), InvoiceType.Trucking);
//        System.out.println("Trucking: " + truckingList.size());
//
//
//        for (Trucking trucking : truckingList) {
//
//            computeLoaderAndHelper(empList, trucking);
//
//            //compute driver transaction
//            if (trucking.getDriver() != null) {
//                Employee e = empList.get(trucking.getDriver().getTid());
//                if (e == null) {
//                    continue;
//                }
//
//                DailyTimeRecord dtr = createDTR(trucking.getDriver().getTid(), trucking, DTRType.Drive);
//
//                dtr.setQuantity(1);
//                dtr.setAmount(e.getSalary());
//                dtr.setNoOfEmployeeSharing(1);
//                dtr.setNetAmount(e.getSalary());
//                e.dtrList.add(dtr);
//                System.out.println("driver: " + e.getIdNumber() + " " + dtr.computationString());
//            }
//
//        }

        return empList;
    }

    public static LinkedHashMap<Long, Employee> processPayslip(PayrollPeriod pp, Employee eep) throws TransactionException, Exception {


        //if payroll period status is finalized

        LinkedHashMap<Long, Employee> empList = processDTRforPayroll(pp, eep);
//        System.out.println("emplist count: " + empList.size());
//        //payables(DTR, deliveries)
//        for (Employee emp : empList.values()) {
//            //emp.payslip = new PaySlip(emp, pp);
//            //payables(DTR, deliveries)
//            LinkedHashMap<String, PaySlipDetail> payslipDetailDTRs = new LinkedHashMap<String, PaySlipDetail>();
//            if (emp.payslip == null) {
//                throw new TransactionException("Please prepared this payroll period, from Payroll Period screen.");
//            }
//            int rowCounter = emp.payslip.getRowCounter();
//            int dailyTimeRecordCounter = 1;
//            for (DailyTimeRecord dtr : emp.dtrList) {
//                System.out.println(dailyTimeRecordCounter++ + " " + emp.getName() + " " + dtr.computationString());
//                //dtrtype: Regular, Leave, Absence, Overtime, Undertime, Deliveries
//
//                PaySlipDetail psd = null;
//
//                String psdCode = "";
//
////                if (dtr.getDtrType().equals("Loading")) {
////                    psdCode = dtr.getDtrType() + dtr.getReference();
////                } else {
////                    psdCode = dtr.getDtrType();
////                }
//                psdCode = dtr.getDtrType();
//
//                if (payslipDetailDTRs.containsKey(psdCode)) {
//                    psd = payslipDetailDTRs.get(psdCode);
//                } else {
//                    psd = new PaySlipDetail(emp.payslip, dtr.getDtrType());
//                  //  psd.setRowNumber(++rowCounter);
//                    payslipDetailDTRs.put(psdCode, psd);
//                    System.out.println("emp.payslip.getPayslipDetails().size(): " + emp.payslip);
//                    System.out.println("emp.payslip.getPayslipDetails().size(): " + emp.payslip.getPayslipDetails());
//                    System.out.println("emp.payslip.getPayslipDetails().size(): " + emp.payslip.getPayslipDetails().size());
//                    emp.payslip.getPayslipDetails().add(psd);
//
//                }
//
//
//                psd.setIsTaxable(false);
//                psd.setIsDeduction(false);
//                psd.setAmount(dtr.getAmount());
//                psd.setTotal(psd.getTotal() + dtr.getNetAmount());
//                psd.setQuantity(psd.getQuantity() + dtr.getQuantity());
//                psd.setDescription(psd.getDescription() + ", " + dtr.getNotes());
//
//                if (dtr.getDtrType().equals("Loading")) {
//
//                    psd.setNoOfLoader(dtr.getNoOfEmployeeSharing());
//                } else {
//                    psd.setNoOfLoader(1);
//                }
//
//
//            }
//
//            //receivable (loans, cash advanced);
//            // payments
//            List<Transaction> transList = Transaction.getAllTransactionWithBalanceEmployee2(emp);
//
//            for (Transaction v : transList) {
//                PaySlipDetail psd = null;
//                if (payslipDetailDTRs.containsKey(v.getNumber())) {
//                    psd = payslipDetailDTRs.get(v.getNumber());
//                } else {
//                    psd = new PaySlipDetail(emp.payslip, v.getTransactionType());
//                    payslipDetailDTRs.put(v.getNumber(), psd);
//                    emp.payslip.getPayslipDetails().add(psd);
//                }
//
//                if (v.getTransactionType().equals(TransactionType.Loans.name())) {
//
//                    psd.setTotal(v.getAmortizaion());
//
//                    String count = "(" + (v.getPaymentCount() + 1) + "/" + v.getTotalPaymentCount() + ")";
//                    String desc = "loan payment" + count;
//                    psd.setDescription(desc);
//                } else  if (v.getTransactionType().equals(TransactionType.Payments.name())) {
//
//                    psd.setTotal(v.getGenBalance() * -1);
//
//                    psd.setDescription(v.getDescription());
//                } else {
//                    psd.setTotal(v.getGenBalance());
//                }
//
//
//                psd.setRowNumber(++rowCounter);
//                psd.setIsTaxable(false);
//                psd.setIsDeduction(true);
//                System.out.println(emp.getName() + " " + psd.getDescription() + " " + psd.getTotal());
//
//            }
//
//            System.out.println("emp.payslip: " + emp.getName() + " count: " + emp.payslip.getPayslipDetails().size());
//
//
//            emp.payslip.setRowCounter(rowCounter);
//        }


        return empList;
    }

//    private static void computeLoaderAndHelper(LinkedHashMap<Integer, Employee> empList, Trucking trucking) throws Exception {
//
//        int loaderCount = trucking.computeNumberOfLoader();
//        int helperCount = 0;
//        double loaderRate = 2.5;
//
//        GlobalDailyRates gdr = GlobalDailyRates.getGlobalDailyRatesByName("Loading");
//        loaderRate = gdr.getRates();
//
//        //compute helper
//        for (TruckingEmployee emp : trucking.getTruckingEmployees()) {
//            System.out.println("Trucking employee: " + emp.getEmployeeTid());
//            Employee e = empList.get(emp.getEmployeeTid());
//            System.out.println("Trucking employee: " + emp.getEmployeeTid() + " : " + e);
//            if (e == null) {
//                continue;
//            }
//
//            double rate = e.getSalary();
//
//            if (emp.getPositionTid() == 2) { // helper
//
//                DailyTimeRecord dtr = createDTR(e.getTid(), trucking, DTRType.Helper);
//
//                if (!e.getPosition().getDescription().equals("Helper")) {
//                    rate = e.getAllowance();
//                    System.out.println("Not helper: " + e.getName() + " : " + e.getPosition().getDescription() + " : " + rate);
//
//                }
//                dtr.setQuantity(1);
//                dtr.setAmount(rate);
//                dtr.setNoOfEmployeeSharing(1);
//                dtr.setNetAmount(rate);
//                e.dtrList.add(dtr);
//                System.out.println("helper: " + e.getIdNumber() + " " + dtr.computationString());
//            }
//        }
//
//        double totalCasesConfirmCases = 0;
//
//        HashMap<String, InventoryBalance> hmap = new HashMap<String, InventoryBalance>();
//        for (TruckingDetail id : trucking.getDetails()) {
//
//            Product p = id.getProduct();
//
//            double qty135 = 0;
//            if (p.getWeight() != 13.5) {
//                qty135 = (int) (id.getQuantity() * p.getWeight() / 13.5);
//            } else {
//                qty135 = id.getQuantity();
//            }
//
//            totalCasesConfirmCases = totalCasesConfirmCases + qty135;
//        }
//
//        double loaderShare = (totalCasesConfirmCases * loaderRate) / loaderCount;
//
//
//        System.out.println("Total Number of cases base 13.5 kgs.: " + totalCasesConfirmCases + "\n");
//
//
//        for (TruckingEmployee emp : trucking.getTruckingEmployees()) {
//            if (emp.getPositionTid() == 3) {// LOader = 3
//                Employee e = empList.get(emp.getEmployeeTid());
//                if (e == null) {
//                    continue;
//                }
//                DailyTimeRecord dtr = createDTR(emp.getEmployeeTid(), trucking, DTRType.Loading);
//
//                dtr.setQuantity(totalCasesConfirmCases);
//                dtr.setAmount(loaderRate);
//                dtr.setNoOfEmployeeSharing(loaderCount);
//                dtr.setNetAmount(loaderShare);
//                System.out.println(e.getIdNumber() + " " + dtr.computationString());
//                e.dtrList.add(dtr);
//            }
//        }
//
//    }

    public static int createPayslipForPayrollPeriod(PayrollPeriod pp, Employee eep) throws Exception {

        int counter = 0;
        LinkedHashMap<Long, PaySlip> empList = PaySlip.getPayslipByEmployee(pp, eep);
        System.out.println("PayslipForPayrollPeriod anti: '" + empList.size());
        List<Employee> listPP = Employee.getEmployees(PayrollPeriodType.valueOf(pp.getPayrollPeriodType()));
        System.out.println("PayslipForPayrollPeriod: " + listPP.size());
        for (Employee e : listPP) {

            PaySlip ps = empList.get(e.getId());
            if (ps == null) {
                ps = new PaySlip(e, pp);
              //  dbms.save(ps);
                counter++;
            }

        }

        return counter;
    }

    public static int finalizedPaySlip(Long payrollPeriodID) throws Exception{

        PayrollPeriod pp = PayrollPeriod.getPayrollPeriodByTid(payrollPeriodID);
        List<Employee> employeeList = preparePayslip(payrollPeriodID, null);
        int counter = 1;

//         for(Employee e: employeeList){
//
//             System.out.print( counter + ". " + e.getName() + " : " + e.payslipReport.getNetTotal());
//             for(DailyTimeRecord dtr: e.dtrList){
//                 dtr.setProcess(true);
//                 dtr.setStatus(PaySlipStatus.Process.name());
//                 dbms.saveNoCommit(dtr);
//             }
//             System.out.print(" [DTR done]");
//             for(PaySlipDetail psd : e.payslip.getPayslipDetails()){
//                 psd.setIsProcess(true);
//                 dbms.saveNoCommit(psd);
//             }
//             e.payslip.setStatus(PaySlipStatus.Process.name());
//             dbms.saveNoCommit(e.payslip);
//             System.out.print(" [Payslip done]");
//             System.out.println("");
//             counter++;
//         }
//
//         pp.setStatus(PayrollPeriodStatus.Generated.name());
//         dbms.save(pp);
         return counter;
    }


    public static String createPayslipDetailDescription(PaySlipDetail psd){
        String desc ="";

//        if(psd.getPaySlipDetailType().equals(DTRType.Loading.name())){
//            desc = psd.getDescription() + " (" + psd.getQuantity() + " X " + MyNumberFormatter.formatAmount(psd.getAmount()) + ") / " + psd.getNoOfLoader();
//        } else if(psd.getPaySlipDetailType().equals(DTRType.Drive.name())){
//            desc = psd.getDescription() + " (" + psd.getQuantity() + " X " + MyNumberFormatter.formatAmount(psd.getAmount()) + ")";
//        } else if(psd.getPaySlipDetailType().equals(DTRType.Helper.name())){
//            desc = psd.getDescription() + " (" + psd.getQuantity() + " X " + MyNumberFormatter.formatAmount(psd.getAmount()) + ")";
//        } else if(psd.getPaySlipDetailType().equals(DTRType.Helper.name())){
//            desc = psd.getDescription() + " (" + psd.getQuantity() + " X " + MyNumberFormatter.formatAmount(psd.getAmount()) + ")";
//        } else {
//            desc = psd.getDescription();
//        }
        return desc;

    }


    public static void main(String[] args) {
        try {
        //    dbms.login("admin", "password");

            PayrollPeriod pp = PayrollPeriod.getPayrollPeriodByTid(1L);
            LinkedHashMap<Long, Employee> emplist = PaySlipProcess.processPayslip(pp, null);
            for (Employee emp : emplist.values()) {
                System.out.println("================================");
                System.out.println(emp);
                System.out.println(emp.getPayslip().getPayrollPeriod().getPayrollPeriodCode());
                System.out.println("Add: ");
                for (PaySlipDetail psd : emp.getPayslip().getPayables()) {
                    System.out.println(psd.getRowNumber() + "     " + psd.getDescription() + " " + psd.getTotal());
                }
                System.out.println("     Less: ");
                for (PaySlipDetail psd : emp.getPayslip().getReceivables()) {
                    System.out.println(psd.getRowNumber() + "     " + psd.getDescription() + " " + psd.getTotal());
                }


            }


        } catch (Exception ex) {
            Logger.getLogger(PaySlipProcess.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}

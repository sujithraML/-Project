package hospitalmanagement;

import java.util.Date;
enum reporttype{SCANREPORT,TESTREPORT}

public class Report {
	
	Date dateofexamination;
	long noofreports;
	Date dateofresult;
	reporttype typereport;
}

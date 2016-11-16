package Postgres;

import Postgres.Entity.RepAndScanStats;
import Postgres.Entity.Reports;
import org.json.JSONObject;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by adyachenko on 11.11.16.
 */
public class GetRepAndScanStats {
    public static List<RepAndScanStats> getRepAndScanStats(String domain) throws SQLException{
        List<RepAndScanStats> rep = new ArrayList<>();
        List<Reports> reports = GetReports.requestReportByDomainId(GetDomains.getDomainIdByName(domain));
        for (Reports report : reports) {
            JSONObject malwareDescription = new JSONObject(report.getFieldMalwareDescription);
            JSONObject reputationDescription = new JSONObject(report.getFieldReputationDescription);
            Date sslScanDate = new Date(reputationDescription.getLong("last_scan_date")*1000);
            Date malwareScanDate = new Date(malwareDescription.getLong("last_scan_date")*1000);
            rep.add(new RepAndScanStats(report.getFieldSslIssues, report.getFieldIsBlacklisted, report.getFieldPhishingDetected,
                    report.getFieldMalwareDetected, report.getFieldInjectedCodeFound, report.getFieldInsecurePermissions,
                    new Timestamp(sslScanDate.getTime()), new Timestamp(malwareScanDate.getTime())));
        }
        return rep;
    }
}

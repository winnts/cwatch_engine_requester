package WebApp;

import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * Created by adyachenko on 29.08.16.
 */
public class MonitorApp extends Application <MonitorAppConfiguration> {
    public static void main(String[] args) throws Exception{
        new MonitorApp().run(args);
    }

    @Override
    public String getName() {
        return "MonitorApp";
    }

    @Override
    public void initialize (Bootstrap<MonitorAppConfiguration> bootstrap){
        bootstrap.addBundle(new AssetsBundle("/webapp", "/app"));

    }


    @Override
    public void run(MonitorAppConfiguration monitorAppConfiguration, Environment environment) {
        final MonitorAppDomains resource = new MonitorAppDomains(
                monitorAppConfiguration.getTemplate(),
                monitorAppConfiguration.getDefaultName()
        );
        final MonitorAppAgents resource1 = new MonitorAppAgents(
                monitorAppConfiguration.getTemplate(),
                monitorAppConfiguration.getDefaultName()
        );
        final MonitorAppApplications resource2 = new MonitorAppApplications(
                monitorAppConfiguration.getTemplate(),
                monitorAppConfiguration.getDefaultName()
        );
        final MonitorAppLicByHost resource3 = new MonitorAppLicByHost(
                monitorAppConfiguration.getTemplate(),
                monitorAppConfiguration.getDefaultName()
        );
        final MonitorAppRepAndScans resource4 = new MonitorAppRepAndScans(
                monitorAppConfiguration.getTemplate(),
                monitorAppConfiguration.getDefaultName()
        );
        final MonitorAppWaf resource5 = new MonitorAppWaf(
                monitorAppConfiguration.getTemplate(),
                monitorAppConfiguration.getDefaultName()
        );
        final MonitorAppOptions resource6 = new MonitorAppOptions(
                monitorAppConfiguration.getTemplate(),
                monitorAppConfiguration.getDefaultName()
        );
        environment.jersey().register(resource);
        environment.jersey().register(resource1);
        environment.jersey().register(resource2);
        environment.jersey().register(resource3);
        environment.jersey().register(resource4);
        environment.jersey().register(resource5);
        environment.jersey().register(resource6);

    }
}

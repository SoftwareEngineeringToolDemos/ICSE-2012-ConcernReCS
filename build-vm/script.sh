#Install OpenJDK
echo "Installing OpenJDK"
sudo apt-get update
sudo apt-get install -y openjdk-7-jdk

#Download and Extract eclipse
echo "Download and Extract eclipse"
cd /tmp
sudo wget -O /tmp/eclipse-SDK-3.7.2-linux-gtk.tar.gz "https://googledrive.com/host/0B5_co1c8kYwDYzRmeWhSZm51Ukk/eclipse.tar.gz"
tar -xzf eclipse-SDK-3.7.2-linux-gtk.tar.gz
sudo mv eclipse/ /home/vagrant/

#Install ConcernMapper and ConcernReCS plugin
echo "Install ConcernMapper and ConcernReCS plugin"
sudo mv /tmp/ufmg.crcs_1.0.0.jar /home/vagrant/eclipse/dropins/ufmg.crcs_1.0.0.jar
unzip features_ca.mcgill.cs.serg.cm_2.0.3.zip
unzip plugins_ca.mcgill.cs.serg.cm_2.0.3.zip
sudo mv /tmp/features_ca.mcgill.cs.serg.cm_2.0.3 /home/vagrant/eclipse/features/ca.mcgill.cs.serg.cm_2.0.3
sudo mv /tmp/plugins_ca.mcgill.cs.serg.cm_2.0.3 /home/vagrant/eclipse/plugins/ca.mcgill.cs.serg.cm_2.0.3
sudo chown -R vagrant:vagrant /home/vagrant/eclipse/

#Configure eclipse and add it to startup
echo "Configure eclipse"
sudo mkdir /home/vagrant/.config/autostart
sudo chown -R vagrant:vagrant /home/vagrant/.config/autostart
sudo mkdir /home/vagrant/workspace
sudo chown -R vagrant:vagrant /home/vagrant/workspace

#Plugin to import eclipse project and eclipse project
wget https://github.com/seeq12/eclipse-import-projects-plugin/blob/7c0939b4862367566463e7a890aa89e5c00aa77a/jar/com.seeq.eclipse.importprojects_1.2.0.jar?raw=true -O /home/vagrant/eclipse/plugins/com.seeq.eclipse.importprojects_1.2.0.jar
wget http://sourceforge.net/projects/concernrecs/files/Chess_OO.zip/download -O /home/vagrant/workspace/chess_oo.zip
cd /home/vagrant/workspace/
unzip chess_oo.zip
rm -f chess_oo.zip

#Copy license and Instructions to desktop
echo "Copy license and Instructions to desktop"
cd /tmp
sudo mkdir /tmp/Desktop
mv Desktop.zip /tmp/Desktop/Desktop.zip
cd Desktop
unzip Desktop.zip
rm -f Desktop.zip
cp /tmp/Desktop/* /home/vagrant/Desktop/
cd /home/vagrant/Desktop
sudo chmod 777 eclipse.desktop
sudo chmod 777 ufmg.crcs_1.0.0.desktop

#Removing unsed sidebar icons
echo "Removing unsed sidebar icons"
sudo mkdir  ~/.local/share/applications
sudo mv /usr/share/applications/ubuntu-software-center.desktop /home/vagrant/.local/share/applications
sudo mv /usr/share/applications/firefox.desktop /home/vagrant/.local/share/applications
sudo mv /usr/share/applications/unity-control-center.desktop /home/vagrant/.local/share/applications
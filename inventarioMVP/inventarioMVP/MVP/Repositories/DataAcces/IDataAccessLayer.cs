namespace CompanyDirectory.DataAccess;
public interface IDataAccessLayer
{
    List<T> LoadData<T>();
    void SaveData<T>(List<T> data);
}



using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace HearingAidsStoreApp.Models;

public class Customer
{
    public int ID { get; set; }
    public string Name { get; set; }
    public string Surname { get; set; }

    //Property to return full name
    [NotMapped]
    public string FullName { get { return $"{Name} {Surname}"; } }

    public string Address { get; set; }

    [DataType(DataType.Date)]
    public DateTime BirthDate { get; set; }
    public string Mail { get; set; }
}

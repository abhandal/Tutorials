using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace AspNetCoreTodo.Models
{
    /// <summary>
    ///     Defines what the database will need to store for each to-do item:
    ///     ID, title or name, whether item is complete, and what the due date is.
    /// </summary>
    public class ToDoItem
    {
        /// <summary>
        ///     Random and are very unlikely to be duplicated
        /// </summary>
        public Guid ID { get; set; }

        public bool isDone { get; set; }

        [Required]
        public string Title { get; set; }

        /// <summary>
        ///     DateTimeOffset stores date/timestamp from UTC
        ///     The '?' means property is nullable/optional
        /// </summary>
        public DateTimeOffset? DueAt { get; set; }

        /// <summary>
        ///     UserId
        /// </summary>
        public string UserId { get; set; }
    }
}

package graphql.examples.repository

import graphql.examples.pojo.Attendee
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AttendeeRepository : JpaRepository<Attendee, Long>

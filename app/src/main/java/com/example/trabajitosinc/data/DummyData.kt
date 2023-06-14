package com.example.trabajitosinc.data

import com.example.trabajitosinc.R
import com.example.trabajitosinc.data.models.CategoryModel
import com.example.trabajitosinc.data.models.UserModel
import com.example.trabajitosinc.data.models.TrabajitoModel

val categories = mutableListOf(
    CategoryModel("Carpentry", R.drawable.carpentry_icon),
    CategoryModel("Electrician", R.drawable.electrician_icon),
    CategoryModel("Housekeeper", R.drawable.housekeeper_icon),
    CategoryModel("Plumbing", R.drawable.plumbing_icon),
    CategoryModel("Welding", R.drawable.welding_icon),
    CategoryModel("Plumbing", R.drawable.plumbing_icon),
    CategoryModel("Welding", R.drawable.welding_icon),
    CategoryModel("Plumbing", R.drawable.plumbing_icon),
    CategoryModel("Welding", R.drawable.welding_icon)
)

val trabajitos = mutableListOf(
    TrabajitoModel(
        workerId = "W001",
        requesterId = "R001",
        workerName = "Alice Johnson",
        workerCategory = "Carpenter",
        workerLocation = "New York, USA",
        phone = "+1 123-456-7890",
        startDate = "2023-06-01",
        endDate = "2023-06-10",
        taskDescription = "Perform data entry and analysis",
        bill = "$500.00",
        TrabajitoStatus = "Completed"
    ),
    TrabajitoModel(
        workerId = "W002",
        requesterId = "R002",
        workerName = "Bob Smith",
        workerCategory = "Carpenter",
        workerLocation = "Los Angeles, USA",
        phone = "+1 987-654-3210",
        startDate = "2023-06-05",
        endDate = "2023-06-15",
        taskDescription = "Design website layout",
        bill = "$800.00",
        TrabajitoStatus = "In Progress"
    ),
    TrabajitoModel(
        workerId = "W003",
        requesterId = "R003",
        workerName = "Emma Davis",
        workerCategory = "Carpenter",
        workerLocation = "London, UK",
        phone = "+44 1234-567890",
        startDate = "2023-06-10",
        endDate = "2023-06-20",
        taskDescription = "Write marketing copy",
        bill = "$600.00",
        TrabajitoStatus = "Pending"
    )

)

val users = mutableListOf(
    UserModel("Jose","Nestor@uca.com",25252525,"Uca", R.drawable.plumbing_icon) ,
    UserModel("Jose","Nestor@uca.com",25252525,"Uca", R.drawable.electrician_icon) ,
    UserModel("Jose","Nestor@uca.com",25252525,"Uca", R.drawable.housekeeper_icon),
    UserModel("Jose","Nestor@uca.com",25252525,"Uca", R.drawable.welding_icon)


    )
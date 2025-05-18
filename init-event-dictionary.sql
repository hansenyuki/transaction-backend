CREATE TABLE IF NOT EXISTS event_dictionary (
    id SERIAL PRIMARY KEY,
    step_code VARCHAR(50),
    step_rank INT,
    event_rank INT,
    event_type VARCHAR(100)
);

INSERT INTO event_dictionary (step_code, step_rank, event_rank, event_type) VALUES
('Acquisition', 2, 1, 'Reception'),
('Acquisition', 2, 2, 'Duplicate'),
('Acquisition', 2, 3, 'DuplicateVerification'),
('Acquisition', 2, 4, 'Duplicate4EyesVerification'),
('Acquisition', 2, 5, '100%VirementHold'),
('Acquisition', 2, 6, '100%VirementVerify'),
('Acquisition', 2, 7, 'OnHold'),
('Acquisition', 2, 8, 'Repair'),
('Acquisition', 2, 9, 'Reception'),
('Acquisition', 2, 10, 'Duplicate'),
('Acquisition', 2, 11, 'DuplicateVerification'),
('Acquisition', 2, 12, 'Duplicate4EyesVerification'),
('Acquisition', 2, 13, '100%VirementHold'),
('Acquisition', 2, 14, '100%VirementVerify'),
('Acquisition', 2, 15, 'OnHold'),
('Acquisition', 2, 16, 'Repair'),
('AcquisitionCB', 1, 1, 'CBAcquired'),
('AcquisitionCB', 1, 2, 'CBPGPAcquired'),
('AcquisitionCB', 1, 3, 'CBAcquiredForBatch'),
('AcquisitionCB', 1, 4, 'CBAcquiredToPfmt101');
